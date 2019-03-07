package seedu.address.model.apparel;

import java.util.Objects;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a Apparel in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Apparel {

    // Identity fields
    private final Name name;
    private final Color color;
    private final ClothingType clothingType;

    // Status fields
    private boolean available;
    private int usageCount;

    /**
     * Every field must be present and not null.
     */
    public Apparel(Name name, Color color, ClothingType clothingType) {
        requireAllNonNull(name, color, clothingType);
        this.name = name;
        this.color = color;
        this.clothingType = clothingType;
        this.available = true;
        this.usageCount = 0;
    }

    public Name getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public ClothingType getClothingType() {
        return clothingType;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getUsageCount() {
        return usageCount;
    }

    public void use() {
        usageCount++;
    }

    public void dirty() {
        available = false;
    }

    public void wash() {
        available = true;
    }

    /**
     * Returns true if both apparels of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two apparels.
     */
    public boolean isSameApparel(Apparel otherApparel) {
        if (otherApparel == this) {
            return true;
        }

        return otherApparel != null
                && otherApparel.getName().equals(getName())
                && (otherApparel.getColor().equals(getColor())
                || otherApparel.getClothingType().equals(getClothingType()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Apparel)) {
            return false;
        }

        Apparel otherApparel = (Apparel) other;
        return otherApparel.getName().equals(getName())
                && otherApparel.getColor().equals(getColor())
                && otherApparel.getClothingType().equals(getClothingType());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, color, clothingType);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Color: ")
                .append(getColor())
                .append(" ClothingType: ")
                .append(getClothingType())
                .append(" Available: ")
                .append(isAvailable())
                .append(" Usage-count: ")
                .append(getUsageCount());

        return builder.toString();
    }

}