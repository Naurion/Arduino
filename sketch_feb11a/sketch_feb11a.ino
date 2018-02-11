#define LED_PIN 13

void setup() {
  Serial.begin(9600);
  pinMode(LED_PIN, OUTPUT);
}

void loop() {
  if (Serial. available() != 0){
    byte b = Serial.read();
    if (b == 49) digitalWrite(LED_PIN, HIGH);
    if (b == 48) digitalWrite(LED_PIN, LOW);
  }
}
