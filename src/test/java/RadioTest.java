import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netogy.home.Radio;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    @Test
    public void shouldIncreaseVolumeMax() { //прибавление на максимальной громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolumeFromMin() { // прибавление громкости с минимальной громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);

    }

    @Test
    public void shouldIncreaseVolumeNorm() { // прибавление громкости: валидное значение
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);

    }

    @Test
    public void ShouldDecreaseVolumeMin() { // убавление громкости с минимальной громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldDecreaseVolumeFromMax() { // убавление громкости с максимальной громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.decreaseVolume();

        int expected = 99;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);

    }

    @Test
    public void ShouldDecreaseVolumeNorm() { // убавление громкости: валидные значения
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.decreaseVolume();

        int expected = 98;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldSwitchFrom9to0() { // переключение с 9 на 0
        Radio radio = new Radio();
        radio.setCurrentChanel(9);
        radio.nextChanel();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldSwitchFrom0to9() { // переключение с 0 на 9
        Radio radio = new Radio();
        radio.setCurrentChanel(0);
        radio.prevChanel();

        int expected = 9;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);

    }

    @Test
    public void ShouldPrev() { // перключение назад: валидные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(8);
        radio.prevChanel();

        int expected = 7;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ShouldNext() { // переключение вперед: валидные значпения
        Radio radio = new Radio();
        radio.setCurrentChanel(5);
        radio.nextChanel();

        int expected = 6;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelNorm() { // выбор канала: валидные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(5);

        int expected = 5;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveMin() { // выбор канала: граничные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(0);

        int expected = 0;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveElseMin() { // выбор канала: граничные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(1);

        int expected = 1;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelBoundaryConditionsNegativeMin() { // выбор канала: граничнфе значения
        Radio radio = new Radio();
        radio.setCurrentChanel(-1);

        int expected = 0;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelBoundaryConditionsNegativeMax() { // выбор канала: граничные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(10);

        int expected = 0;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveMax() { // выбор канала: граничные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(9);

        int expected = 9;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void ChooseChanelBoundaryConditionsPositiveElseMax() { // выбор канала: граничные значения
        Radio radio = new Radio();
        radio.setCurrentChanel(8);

        int expected = 8;
        int actual = radio.getCurrentChanel();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldVolumeMoreMax() { // громкость выше максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(101);


        int expected = 0;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldVolumeLoverMin() { // громкость ниже максимума
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

}
