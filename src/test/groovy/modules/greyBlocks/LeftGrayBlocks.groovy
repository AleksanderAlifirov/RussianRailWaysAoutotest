package modules.greyBlocks

class LeftGrayBlocks extends GrayBlock_Base {
    def container = '//td[@class=\'leftCol\']'
    static content = {
        Passengers { module Passengers }
        Shipping { module Shipping }
    }

}
