package modules.greyBlocks

import org.openqa.selenium.By
import org.openqa.selenium.Keys

class Passengers extends GrayBlock_Base {
    static content = {
        Field_Departure { $(By.xpath('//input[@id="name0"]'))  }
        Field_Destination { $(By.xpath('//input[@id="name1"]')) }
        Field_Date { $(By.xpath('//input[@title="Дата"]')) }
        ListOfDepartures { $(By.className('dropList'))[0] }
        ListOfDestinations { $(By.className('dropList'))[1] }
    }

    def listOfDeparturesIsDisplayed(){
        String departure = 'Москва'
        Field_Departure.value(departure)
        println "   В поле 'Откуда' введено значение '$departure'"
        if (ListOfDepartures.displayed) {
            println "   Список станций 'Откуда' отображается."
            return true
        } else {
            println "   Список станций 'Откуда' не отобразился."
            return false
        }
    }

    def listOfDestinationIsDisplayed(){
        String departure = 'Санкт-Петербург'
        Field_Destination.value(departure)
        println "   В поле 'Откуда' введено значение '$departure'"
        if (ListOfDestinations.displayed) {
            println "   Список станций 'Откуда' отображается."
            return true
        } else {
            println "   Список станций 'Откуда' не отобразился."
            return false
        }
    }

    ArrayList<String> getListOfDepartures(){
        ArrayList<String> listOfStations = $(By.className('dropList'))[0].children()*.text()
        println "   Получен список станций доступных для выбора в поле 'Откуда'"
        println "   $listOfStations"
        return listOfStations
    }

    List<String> getListOfDestinations(){
        ArrayList<String> listOfStations = $(By.className('dropList'))[1].children()*.text()
        println "   Получен список станций доступных для выбора в поле 'Куда'"
        println "   $listOfStations"
        return listOfStations
    }

    def selectDepartureStationByClick(String station){
        Field_Departure.value(station.substring(0, 3))
        $(By.className('dropList'))[0].children().each {
            if (it.getAttribute('textContent') == station) {
                it.click()
        }
        }
    }

    def selectDestinationStationByClick(String station){
        Field_Destination.value(station.substring(0, 3))
        $(By.className('dropList'))[1].children().each {
            if (it.getAttribute('textContent') == station) {
                it.click()
            }
        }
    }

    def selectDepartureStationByKeyPressing(String station){
        Boolean choosing = false
        Field_Departure.value(station.substring(0, 3))
        $(By.className('dropList'))[0].children().any {
            interact { sendKeys(Keys.ARROW_DOWN) }
            if (it.getAttribute('textContent') == station) {
                interact { sendKeys(Keys.ENTER)
                }
                println "   В поле 'Откуда' выбрана станция $station нажатием клавиши."
                choosing = true
                return true
            }
        }
        assert choosing :"   В списке 'Откуда' станция $station отсутствует."
    }

    def selectDestinationStationByKeyPressing(String station){
        Boolean choosing = false
        Field_Destination.value(station.substring(0, 3))
        $(By.className('dropList'))[1].children().any {
            interact { sendKeys(Keys.ARROW_DOWN) }
            if (it.getAttribute('textContent') == station) {
                interact { sendKeys(Keys.ENTER)
                }
                println "   В поле 'Куда' выбрана станция $station нажатием клавиши."
                choosing = true
                return true
            }
        }
        assert choosing :"   В списке 'Куда' станция $station отсутствует."
    }
}
