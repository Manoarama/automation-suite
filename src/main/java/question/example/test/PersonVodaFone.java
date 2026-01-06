package question.example.test;

import java.util.*;
/*Create a Person class that contains first name, last name, and ID. -
Create a getCommonLastNames() method that takes List<Person> as a parameter
The method should return a Map<String, List<Person>> whereby the key is the common
last name and the value is the list of people that share the same last name.*/
//VodaFone

 class PersonVodaFone {
        private String firstName;
        private String lastName;
        private int id;

        // Constructor to initialize Person objects.
        public PersonVodaFone(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        // Getter for first name.
        public String getFirstName() {
            return firstName;
        }

        // Getter for last name.
        public String getLastName() {
            return lastName;
        }

        // Getter for ID.
        public int getId() {
            return id;
        }

        // Overrides toString() to provide a meaningful string representation of Person objects.
        @Override
        public String toString() {
            return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", id=" + id + '}';
        }

        /**
         * Groups people by their last name and returns a map of last names to lists of people.
         * Only includes last names that appear more than once.
         * @param personVodaFones List of Person objects.
         * @return Map where keys are last names and values are lists of people with that last name.
         */
        public static Map<String, List<PersonVodaFone>> getCommonLastNames(List<PersonVodaFone> personVodaFones) {
            Map<String, List<PersonVodaFone>> lastNameMap = new HashMap<>();


            for (PersonVodaFone personVodaFone : personVodaFones) {

                // If last name is not already present, add it
                if (!lastNameMap.containsKey(personVodaFone.lastName)) {
                    lastNameMap.put(personVodaFone.lastName, new ArrayList<>());
                }

                // Add person to the list of that last name
                lastNameMap.get(personVodaFone.lastName).add(personVodaFone);
            }

            return lastNameMap;

        }

        // Main method to demonstrate functionality.
        public static void main(String[] args) {
            List<PersonVodaFone> people = Arrays.asList(
                    new PersonVodaFone("John", "Doe", 1),
                    new PersonVodaFone("Jane", "Doe", 2),
                    new PersonVodaFone("Alice", "Smith", 3),
                    new PersonVodaFone("Bob", "Johnson", 4),
                    new PersonVodaFone("Charlie", "Smith", 5)
            );

            // Retrieve and print last names that are shared by multiple people.
            Map<String, List<PersonVodaFone>> commonLastNames = getCommonLastNames(people);
            /*for (Map.Entry<String, List<PersonVodaFone>> entry : commonLastNames.entrySet()) {
                System.out.println("Last Name: " + entry.getKey());
                for (PersonVodaFone personVodaFone : entry.getValue()) {
                    System.out.println(personVodaFone);
                }
            }*/
            // Print result
            for (String lastName : commonLastNames.keySet()) {
                System.out.println(lastName + " -> " + commonLastNames.get(lastName));
            }
        }
    }


