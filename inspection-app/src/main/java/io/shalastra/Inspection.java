package io.shalastra;

import lombok.Data;

@Data
public class Inspection {

  private int inspectionID;
  private String restaurantName;
  private String otherName;
  private int licenseNumber;
  private String facilityType;
  private String risk;
  private String address;
  private String city;
  private String state;
  private String zip;
  private String inspectionDate;
  private String inspectionType;
  private String results;
  private String violations;
  private double latitude;
  private double longitude;
  private String location;
}
