package pages
import geb.Page
import modules.greyBlocks.LeftGrayBlocks
import modules.header.RzdHeader

class RzdStartPage extends Page {
    static at = { title == 'ОАО "РЖД"'}
    static content = {
        Логотип { $("//img[@alt='ОАО ']") }
        Меню_Заголовка { module RzdHeader }
        Left_GrayBlock { module LeftGrayBlocks }

    }

}