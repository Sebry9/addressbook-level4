package seedu.address.model.insurance;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Commission {
    public static final String MESSAGE_COMMISSION_CONSTRAINTS = "Comission can only contain numbers";
    public static final String COMMISSION_VALIDATION_REGEX = "\\d";
    public final String value;

    /**
     * Constructs a {@code Phone}.
     *
     * @param commission A valid commission.
     */
    public Commission(String commission) {
        requireNonNull(commission);
        checkArgument(isValidCommission(commission), MESSAGE_COMMISSION_CONSTRAINTS);
        this.value = commission;
    }

    /**
     * Returns true if a given string is a valid person phone number.
     */
    public static boolean isValidCommission(String test) {
        return test.matches(COMMISSION_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Commission // instanceof handles nulls
                && this.value.equals(((Commission) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
