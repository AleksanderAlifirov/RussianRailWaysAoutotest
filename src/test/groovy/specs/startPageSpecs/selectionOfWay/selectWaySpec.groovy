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
        openStartPage()
        def view = at RzdStartPage
        assert view.Left_GrayBlock.Passengers.Field_Departure.displayed
        println "   Поле 'Откуда' присутствует."
        assert view.Left_GrayBlock.Passengers.Field_Destination.displayed
        println "   Поле 'Куда' присутствует."
        view.Left_GrayBlock.Passengers.Field_Departure.value('Москва')

    }
}
