package specs.startPageSpecs.selectionOfWay

import pages.RzdStartPage
import pages.TicketsAndPlace
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
        view.Left_GrayBlock.Passengers.selectDepartureStationByClick(departure)
        println "   В поле 'Откуда' выбрана станция $departure"
        view.Left_GrayBlock.Passengers.selectDestinationStationByClick(destination)
        println "   В поле 'Куда' выбрана станция $destination"
        view.Left_GrayBlock.Passengers.Field_Date.displayed
        view.Left_GrayBlock.Passengers.inputDate('22.02.2019')
        waitFor { !view.Left_GrayBlock.Passengers.Field_Date.isEmpty() }
        view.Left_GrayBlock.Passengers.selectFutureDate('25.07.2019')
        view.Left_GrayBlock.Passengers.pressButtonSubmit()
        at TicketsAndPlace
    }
}
