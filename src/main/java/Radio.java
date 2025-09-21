package ru.netogy.home;

public class Radio {
    private int currentVolume; // текущая громкость
    private int currentChanel; // текущая станция

    public int getCurrentVolume() {
        return currentVolume; // для получения текущей громкости
    }

    public int getCurrentChanel() {
        return currentChanel; // для получения текущей станции
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0) {  //условия для возможной громкости
            return;
        }
        if (newCurrentVolume > 100) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void setCurrentChanel(int newCurrentChanel) {
        if (newCurrentChanel < 0) { // условия для возможных каналов
            return;
        }
        if (newCurrentChanel > 9) {
            return;
        }
        currentChanel = newCurrentChanel;
    }

    public void increaseVolume() {
        if (currentVolume < 100) { // добавление громкости
            currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) { // убавление громкости
            currentVolume = currentVolume - 1;
        }

    }

    public void nextChanel() {
        if (currentChanel < 9) { // переключение каналов вперед
            currentChanel = currentChanel + 1;
        } else currentChanel = 0;
    }

    public void prevChanel() {
        if (currentChanel > 0) { // переключение каналов назад
            currentChanel = currentChanel - 1;
        } else currentChanel = 9;

    }

}
