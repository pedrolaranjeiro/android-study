package com.flat14.study.domain.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class CityWeatherTest{

    @Test
    fun `Given an icon When an icon url Then return an open weather url`(){
        // Given
        val iconId = "iconId"
        val expected = "https://openweathermap.org/img/wn/iconId@2x.png"

        // When
        val actual = getIconUrl(iconId)

        // Then
        assertEquals(expected, actual)
    }

}