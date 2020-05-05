package info.nightscout.androidaps.skins

import info.nightscout.androidaps.Config
import info.nightscout.androidaps.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SkinClassic @Inject constructor(): SkinInterface {

    override val description: Int get() = R.string.classic_desrciption

    override fun overviewLayout(isLandscape: Boolean, isTablet: Boolean, isSmallHeight: Boolean): Int =
        when {
            Config.NSCLIENT && isTablet  -> R.layout.overview_fragment_nsclient_tablet
            Config.NSCLIENT              -> R.layout.overview_fragment_nsclient
            isSmallHeight || isLandscape -> R.layout.overview_fragment_landscape
            else                         -> R.layout.overview_fragment
        }

}