package specs

import pages.RzdStartPage
import rzd.RzdSpec
import spock.lang.Stepwise

@Stepwise
class StartPageSpec extends RzdSpec {
    def "Загрузка страницы www.rzd.ru"() {
        given:

        openStartPage()
        at RzdStartPage
        println "   Стартовая страница присутствует."
    }
}
