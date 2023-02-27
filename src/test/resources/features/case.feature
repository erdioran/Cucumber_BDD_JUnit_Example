Feature: Supplementler.com - UI

  @MAIN @TOPMENU
  Scenario Outline: Top Menu - All Pages Open From The Top Menu
    Given open home page
    When select "<category>" page in top menu
    Then "<productListTitle>" text is on the product list title
    When select "<category2>" page in top menu
    Then "<productListTitle2>" text is on the product list title
    When select "<category3>" page in top menu
    Then "<productListTitle3>" text is on the product list title
    When select "<category4>" page in top menu
    Then "<productListTitle4>" text is on the product list title
    When select "<category5>" page in top menu
    Then "<productListTitle5>" text is on the product list title

    Examples:
      | category     | productListTitle | category2  | productListTitle2 | category3     | productListTitle3 | category4         | productListTitle4 | category5         | productListTitle5 |
      | Protein Tozu | Protein Tozuxxxx     | Amino Asit | Amino Asit        | Kilo ve Hacim | Kilo ve Hacim     | L-Karnitin ve CLA | L-Karnitin ve CLA | Performans ve Güç | Performans ve Güç |
