package pages

import geb.Page

class TicketsAndPlace extends Page {
    static at = { browser.driver.getCurrentUrl().contains('pass.rzd.ru/tickets/public') }
}
