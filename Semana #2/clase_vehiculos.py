class Automovil():
    def __init__(self, color, modelo, tipo):
        self.color = color
        self.modelo = modelo
        self.tipo = tipo
        self.velocidad = 0
        self.numeroPlaca = ""

    def registrarPlaca(self, placa):
        if self.numeroPlaca == "":
            self.numeroPlaca = placa
            print("El vehículo ha sido registrado con la placa:", self.numeroPlaca)
        else:
            print("El vehículo ya tiene una placa registrada, la cual es:", self.numeroPlaca)

    def cambiarColor(self, color):
        self.color = color
        print("El vehículo ahora es de color " + self.color + ".")

    def acelerar(self, velocidad):
        self.velocidad += velocidad
        print("Se aumentó la velocidad por", velocidad, "km/h, el vehículo ahora va a", self.velocidad, "km/h.")

    def desacelerar(self, velocidad):
        self.velocidad -= velocidad
        print("Se disminuyó la velocidad por", velocidad, "km/h, el vehículo ahora va a", self.velocidad, "km/h.")

    def frenar(self):
        self.velocidad = 0
        print("El vehículo frenó.")

vehiculo1 = Automovil("gris", "Hyundai Tucson 2.0L", "Automático")
vehiculo1.registrarPlaca(139584)
vehiculo1.acelerar(70)
vehiculo1.desacelerar(15)
vehiculo1.frenar()
vehiculo1.cambiarColor("azul")
vehiculo1.registrarPlaca(293843)
vehiculo1.acelerar(65)
vehiculo1.desacelerar(25)
vehiculo1.cambiarColor("negro")