package org.src.challenges;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class that provides functionality to group and sort tickets
 * representing a continuous journey from a starting location to an endpoint.
 */
public class TicketsRearrangement {

    /**
     * Reconstructs and returns the ordered list of tickets representing a complete journey.
     * <p>
     * Each ticket contains an origin and a destination. The input list is assumed
     * to contain exactly one valid, non-cyclic path where:
     * - Only one ticket starts at the journey's true origin (never appears as a destination),
     * - All subsequent tickets connect origin-to-destination in a linear fashion.
     * <p>
     * The method builds a map from origin to ticket for efficient O(1) lookups,
     * finds the starting ticket, and reconstructs the full journey in order.
     *
     * @param tickets the unordered list of tickets forming a valid single journey
     * @return a list of tickets sorted in the order of the journey
     */
    static List<Ticket> getSortedTickets(List<Ticket> tickets) {
        List<Ticket> orderedTickets = new LinkedList<>();

        // Build a map of origin → ticket for fast access
        Map<String, Ticket> ticketsMap = tickets.stream()
                .collect(Collectors.toMap(Ticket::getOrigin, ticket -> ticket));

        // Collect all origin and destination cities
        Set<String> origins = new HashSet<>(ticketsMap.keySet());
        Set<String> destinations = tickets.stream()
                .map(Ticket::getDestination)
                .collect(Collectors.toSet());

        // Determine the true starting city (origin that is not a destination)
        origins.removeAll(destinations);
        String start = origins.stream().findFirst().orElse("");

        // Traverse the journey in order using the origin → ticket map
        while (ticketsMap.containsKey(start)) {
            Ticket currentTicket = ticketsMap.get(start);
            orderedTickets.add(currentTicket);
            start = currentTicket.getDestination();
        }

        return orderedTickets;
    }

    /**
     * Main method demonstrating the sorting of an unordered ticket list
     * into the correct travel sequence.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>(Arrays.asList(
                new Ticket("DEL", "UTK"),
                new Ticket("BLR", "BOM"),
                new Ticket("BOM", "MAA"),
                new Ticket("KUL", "BLR"),
                new Ticket("MAA", "DEL")
        ));

        System.out.println(getSortedTickets(tickets));
    }

    /**
     * A simple POJO class representing a travel ticket with an origin and a destination.
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    static class Ticket {
        private String origin;
        private String destination;
    }
}
