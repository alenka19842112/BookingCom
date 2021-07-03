Feature: Search on Booking.com

  Scenario: Search by city
    Given User is looking for hotels in "Minsk" city
    When user does search
    Then Hotel 'Hostel Urban' should be on the Search results page
    Then Hotel 'Hostel Urban' rating is '9.2'

  Scenario Outline: Search by city two
    Given User is looking for hotels in "<City>" city
    When user does search
    Then Hotel '<HotelName>' should be on the Search results page

    Examples:
      | City  | HotelName               |
      | Minsk | Hostel Urban            |
      | Brest | Hampton by Hilton Brest |
      | Gomel | AMAKS Visit Hotel       |