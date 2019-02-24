package modules.greyBlocks

import dialogs.DialogCalendar
import geb.module.FormElement
import org.openqa.selenium.By
import org.openqa.selenium.Keys

import java.lang.reflect.Field

class Passengers extends GrayBlock_Base {
    static content = {
        Field_Departure { $(By.xpath('//input[@id="name0"]'))  }
        Field_Destination { $(By.xpath('//input[@id="name1"]')) }
        Field_Date { $(By.xpath('//input[@title="Дата"]')) }
        ListOfDepartures { $(By.className('dropList'))[0] }
        ListOfDestinations { $(By.className('dropList'))[1] }
        ArrowRight { $(By.xpath('//span[@class="date-arrow right"]')) }
        ArrowLeft { $(By.xpath('//span[@class="date-arrow left"]')) }
        Calendar_Icon { $(By.xpath('//div[@class=\'detailsItem InputWCalendar j-input-group\']')) }
        Calendar { module DialogCalendar }
        Button_Submit { $(By.id("Submit")) }
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

    def inputDate(String date){
        Field_Date.value(date)
        println "   В поле 'Дата' установлено значение $date"
    }

    def selectFutureDate(String date){
        String previousDate = Field_Date.value()
        while(!Field_Date.value().toString().contains(date)){
            ArrowRight.click()
            waitFor { Field_Date.value() != previousDate }
            previousDate = Field_Date.value()
        }
        assert Field_Date.value().toString().contains(date) : " Нужная дата не выбрана"
        println "   Дата $date выбрана."
    }

    def selectPastDate(String date){
        String previousDate = Field_Date.value()
        while(!Field_Date.value().toString().contains(date)){
            ArrowLeft.click()
            waitFor { Field_Date.value() != previousDate }
            previousDate = Field_Date.value()
        }
        assert Field_Date.value().toString().contains(date) : " Нужная дата не выбрана"
        println "   Дата $date выбрана."
    }

    def pressButtonSubmit(){
        println "   Ожидаем, что кнопка 'Найти' доступна для нажатия"
        waitFor { Button_Submit.module(FormElement).isEnabled() }
        println "   Нажимается кнопка 'Найти'"
        Button_Submit.click()
        println "   Кнопка нажата"
    }
}
