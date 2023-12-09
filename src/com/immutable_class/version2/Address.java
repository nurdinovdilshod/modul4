package com.immutable_class.version2;

public final class Address {
    private final String region;
    private final String street;

    public Address(String region, String street) {
        this.region = region;
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "region='" + region + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
