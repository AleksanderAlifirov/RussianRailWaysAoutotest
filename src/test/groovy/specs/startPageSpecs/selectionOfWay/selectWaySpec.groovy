package specs.startPageSpecs.selectionOfWay

import pages.RzdStartPage
import rzd.RzdSpec
import spock.lang.Stepwise
import spock.lang.Title

@Stepwise
@Title('Проверка возможнсти выбора маршрута')
class selectWaySpec extends RzdSpec {
    def "Type the departure station"(){
        given:
        String departure = 'МОСКВА'
        String destination = 'САНКТ-ПЕТЕРБУРГ'
        openStartPage()
        def view = at RzdStartPage
        view.Left_GrayBlock.Passengers.Field_Date.displayed
        /*assert view.Left_GrayBlock.Passengers.listOfDeparturesIsDisplayed()
        assert view.Left_GrayBlock.Passengers.getListOfDepartures()
        println "   Список станций 'Откуда' не пустой."
        view.Left_GrayBlock.Passengers.Field_Departure.value("")
        println "   Поле 'Откуда' очищено"
        assert view.Left_GrayBlock.Passengers.listOfDestinationIsDisplayed()
        assert view.Left_GrayBlock.Passengers.getListOfDestinations()
        println "   Список станций 'Куда' не пустой."
        view.Left_GrayBlock.Passengers.Field_Destination.value("")
        println "   Поле 'Куда' очищено"
        view.Left_GrayBlock.Passengers.selectDepartureStationByClick(departure)
        println "   В поле 'Откуда' выбрана станция $departure"
        view.Left_GrayBlock.Passengers.selectDestinationStationByClick(destination)
        println "   В поле 'Куда' выбрана станция $destination"
        view.Left_GrayBlock.Passengers.Field_Departure.value("")
        println "   Поле 'Откуда' очищено"
        view.Left_GrayBlock.Passengers.Field_Destination.value("")
        println "   Поле 'Куда' очищено"
        view.Left_GrayBlock.Passengers.selectDepartureStationByKeyPressing(departure)
        view.Left_GrayBlock.Passengers.selectDestinationStationByKeyPressing(destination)*/
    }
}
