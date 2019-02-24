package dialogs

import org.openqa.selenium.By

class DialogCalendar extends Dialog_Base {
    def id = 'popup_calendar'
    static String monthName
    static content = {
        Arrow_NextMonth { $(By.xpath("//span[@class='next-month']")) }
        Arrow_PreviousMonth { $(By.xpath("//span[@class='prev-month']")) }
        Month { $(By.xpath("//div[@class='month_title']//span[contains(text(), '$monthName')]/following::ul[@class='numbers clearfix']")) }
    }
}
