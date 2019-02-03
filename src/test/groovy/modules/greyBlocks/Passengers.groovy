package modules.greyBlocks

import org.openqa.selenium.By

class Passengers extends GrayBlock_Base {
    static content = {
        Field_Departure { $(By.xpath('//input[@id="name0"]'))  }
        Field_Destination { $(By.xpath('//input[@id="name1"]')) }
    }
}
