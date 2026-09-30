void main() {
    record Time(int hour, int minute) {
        float getExactHour() {
            return hour + minute / 60.0f;
        }
    }

    record Clock(Time time, int radius) {
        Pict draw() {
            Pict clock = new Circle(radius, "white");
            clock = clock.addLine(radius,radius, radius + 0.5 * radius * Math.sin(2 * Math.PI * (time.getExactHour() / 12)), radius + 0.5 * radius * Math.cos(2 * Math.PI * (time.getExactHour() / 12)), 3, "black");
            clock = clock.addLine(radius,radius, radius + 0.8 * radius * Math.sin(2 * Math.PI * (time.minute / 60.0f)), radius + 0.8 * radius * Math.cos(2 * Math.PI * (time.minute / 60.0f)), 3, "black");
            return clock;
        }
    }

    Clock clock = new Clock(new Time(3, 15), 100);
    ImageIO_.save(clock.draw(), "clock315.png");

    Clock clock2 = new Clock(new Time(9, 45), 100);
    ImageIO_.save(clock2.draw(), "clock945.png");

    Clock clock3 = new Clock(new Time(12, 0), 100);
    ImageIO_.save(clock3.draw(), "clock1200.png");
}