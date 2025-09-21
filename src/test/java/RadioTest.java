import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netogy.home.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldIncreaseVolumeMax() { //прибавление на максимальной громкости
        radio.setCurrentVolume(100);
        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeFromMin() { // прибавление громкости с минимальной громкости
        radio.setCurrentVolume(0);
        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolumeNorm() { // прибавление громкости: валидное значение
        radio.setCurrentVolume(99);
        radio.increaseVolume();

        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void ShouldDecreaseVolumeMin() { // убавление громкости с минимальной громкости
        radio.setCurrentVolume(0);
        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void ShouldDecreaseVolumeFromMax() { // убавление громкости с максимальной громкости
        radio.setCurrentVolume(100);
        radio.decreaseVolume();

        assertEquals(99, radio.getCurrentVolume());
    }

    @Test
    public void ShouldDecreaseVolumeNorm() { // убавление громкости: валидные значения
        radio.setCurrentVolume(99);
        radio.decreaseVolume();

        assertEquals(98, radio.getCurrentVolume());
    }

    @Test
    public void ShouldSwitchFromNinetoZero() { // переключение с 9 на 0
        radio.setCurrentChanel(9);
        radio.nextChanel();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void ShouldSwitchFromZerotoNine() { // переключение с 0 на 9
        radio.setCurrentChanel(0);
        radio.prevChanel();

        assertEquals(9, radio.getCurrentChanel());

    }

    @Test
    public void ShouldPrev() { // перключение назад: валидные значения
        radio.setCurrentChanel(8);
        radio.prevChanel();

        assertEquals(7, radio.getCurrentChanel());
    }

    @Test
    public void ShouldNext() { // переключение вперед: валидные значпения
        radio.setCurrentChanel(5);
        radio.nextChanel();

        assertEquals(6, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelNorm() { // выбор канала: валидные значения
        radio.setCurrentChanel(5);

        assertEquals(5, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveMin() { // выбор канала: граничные значения
        radio.setCurrentChanel(0);

        assertEquals(0, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveElseMin() { // выбор канала: граничные значения
        radio.setCurrentChanel(1);

        assertEquals(1, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelBoundaryConditionsNegativeMin() { // выбор канала: граничнфе значения
        radio.setCurrentChanel(-1);

        assertEquals(0, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelBoundaryConditionsNegativeMax() { // выбор канала: граничные значения
        radio.setCurrentChanel(10);

        assertEquals(0, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveMax() { // выбор канала: граничные значения
        radio.setCurrentChanel(9);

        int expected = 9;
        int actual = radio.getCurrentChanel();

        assertEquals(9, radio.getCurrentChanel());
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveElseMax() { // выбор канала: граничные значения
        radio.setCurrentChanel(8);

        int expected = 8;
        int actual = radio.getCurrentChanel();

        assertEquals(8, radio.getCurrentChanel());
    }

    @Test
    public void shouldVolumeMoreMax() { // громкость выше максимума
        radio.setCurrentVolume(101);

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldVolumeLoverMin() { // громкость ниже максимума
        radio.setCurrentVolume(-1);

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void ShouldConstructorByDefault() { // значение конструктора по умолчанию
        assertEquals(10, radio.getStationCount());
        assertEquals(9, radio.getMaxChanel());
    }

    @Test
    public void ConstructorNotByDefault() { // значение конструктора не по умолчанию
        Radio radio = new Radio(26);

        assertEquals(26, radio.getStationCount());
        assertEquals(25, radio.getMaxChanel());
    }

    @Test
    public void StationFromZero() { // конструктор возвращает к значениям по умолчанию
        Radio radio = new Radio(0);
        assertEquals(10, radio.getStationCount());
        assertEquals(9, radio.getMaxChanel());
    }

    @Test
    public void ShouldPrevNotByDefault() { // переключение назад при значениях не по умолчанию
        Radio radio = new Radio(25);
        radio.setCurrentChanel(13);
        radio.prevChanel();

        assertEquals(12, radio.getCurrentChanel());
    }

    @Test
    public void ShouldNextNotByDefault() { // переключение вперед при значениях не по умолчанию
        Radio radio = new Radio(15);
        radio.setCurrentChanel(13);
        radio.nextChanel();

        assertEquals(14, radio.getCurrentChanel());
    }

    @Test
    public void NextFromMaxtoZero() { // переключение с максимальной на 0
        Radio radio = new Radio(15);
        radio.setCurrentChanel(14);
        radio.nextChanel();

        assertEquals(0, radio.getCurrentChanel());
    }

    @Test
    public void PrevFromZeroToMax() { // переключение с минимальной на максимальную
        Radio radio = new Radio(20);
        radio.setCurrentChanel(0);
        radio.prevChanel();

        assertEquals(19, radio.getCurrentChanel());
    }
}