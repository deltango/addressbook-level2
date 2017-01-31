package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    //public static final String EXAMPLE = "123, some street";
    //public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    
    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses follows the following format BLOCK, STREET, UNIT, POSTAL_CODE";
    
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_SPLITTER = ", ";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        //String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;

        String[] addressArgs = address.trim().split(ADDRESS_SPLITTER);
        Block block = new Block(addressArgs[0]);
        Street street = new Street(addressArgs[1]);
        Unit unit = new Unit(addressArgs[2]);
        PostalCode postalCode = new PostalCode(Integer.parseInt(addressArgs[3]));
        
        if (!isValidAddress(block, street, unit, postalCode)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        this.value = block.get_value() + ADDRESS_SPLITTER 
                + street.get_value() + ADDRESS_SPLITTER 
                + unit.get_value() + ADDRESS_SPLITTER 
                + String.valueOf(postalCode.get_value());
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    /**
     * Returns true if all parts of address is valid
     */
    public static boolean isValidAddress(Block block, Street street, Unit unit, PostalCode postalCode) {
        return block.get_value().matches(ADDRESS_VALIDATION_REGEX)
                && street.get_value().matches(ADDRESS_VALIDATION_REGEX)
                && unit.get_value().matches(ADDRESS_VALIDATION_REGEX)
                && String.valueOf(postalCode.get_value()).matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
