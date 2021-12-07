package com.flat14.study.data

import com.flat14.study.data.model.OpenCityWeather
import com.flat14.study.data.model.OpenWeather
import com.flat14.study.domain.model.CityWeather
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class OpenWeatherRepositoryTest {

    @Test
    fun `Given a repository When get current weather Then return a CityWeather object`() =
        runBlocking {
            // Given
            val cityName = "cityName"
            val expected = CityWeather(
                name = "",
                weather = "",
                description = "",
                icon = "",
                temperature = 0.0,
                feelsLike = 0.0,
                min = 0.0,
                max = 0.0,
                humidity = 0.0
            )
            val weatherApi = mockk<WeatherAPI>()
            val openCityWeather = mockk<OpenCityWeather>(relaxed = true)
            val repository = OpenWeatherRepository(weatherApi)

            every { openCityWeather.weather } returns listOf(mockk(relaxed = true))
            coEvery { weatherApi.getWeatherForCity(cityName) } returns openCityWeather

            // When
            val actual = repository.getCurrentWeather(cityName)

            // Then
            assertEquals(expected, actual)
        }

}