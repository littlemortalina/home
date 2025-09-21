package ru.netogy.home;

public class Radio {
    private int currentVolume; // текущая громкость
    private int currentChanel; // текущая станция
    private int maxChanel; // максимальная станция
    private int stationCount; // максимальное количество станций

    // кончтруктор с параметром
    public Radio(int stationCount) {
        if (stationCount <= 0) {
            stationCount = 10; //
        }
        this.stationCount = stationCount;
        this.maxChanel = stationCount - 1;

    }

    // Конструктор по умолчанию
    public Radio() {
        this(10);// 10 станций по умолчанию
    }


    public int getMaxChanel() {
        return maxChanel; // для получения максимальной станции
    }

    public int getCurrentVolume() {
        return currentVolume; // для получения текущей громкости
    }

    public int getCurrentChanel() {
        return currentChanel; // для получения текущей станции
    }

    public int getStationCount() {
        return stationCount; // для получения количества станций
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
        if (newCurrentChanel > maxChanel) {
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
        if (currentChanel < maxChanel) { // переключение каналов вперед
            currentChanel = currentChanel + 1;
        } else {
            currentChanel = 0;
        }
    }

    public void prevChanel() {
        if (currentChanel > 0) { // переключение каналов назад
            currentChanel = currentChanel - 1;
        } else {
            currentChanel = maxChanel;
        }

    }
}