class Automovil():
    def __init__(self, color, modelo, tipo):
        self.Color = color
        self.Modelo = modelo
        self.Tipo = tipo
        self.Velocidad = 0
        self.Placa = None

    def registrar_placa(self, placa):
        if self.Placa == None:
            self.Placa = placa
            print("El vehículo ha sido registrado con la placa: " + self.Placa)
        else:
            print("El vehículo ya tiene una placa registrada, la cual es: " + self.Placa)

    def cambiar_color(self, color):
        self.Color = color
        print("El vehículo ahora es de color " + color + ".")

    def acelerar(self, velocidad):
        self.Velocidad += velocidad
        print("Se aumentó la velocidad por", velocidad, "km/h, el vehículo ahora va a", self.Velocidad, "km/h.")

    def desacelerar(self, velocidad):
        self.Velocidad -= velocidad
        print("Se disminuyó la velocidad por", velocidad, "km/h, el vehículo ahora va a", self.Velocidad, "km/h.")

    def frenar(self):
        self.Velocidad = 0
        print("El vehículo frenó.")

vehiculo1 = Automovil("gris", "Hyundai Tucson 2.0L", "Automático")
vehiculo1.registrar_placa("139584")
vehiculo1.acelerar(70)
vehiculo1.desacelerar(15)
vehiculo1.frenar()
vehiculo1.cambiar_color("azul")
vehiculo1.registrar_placa("293843")
vehiculo1.acelerar(65)
vehiculo1.desacelerar(25)
vehiculo1.cambiar_color("negro")