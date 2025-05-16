package Sesion1.Ejemplo4;

// Clase base sellada: solo las clases permitidas pueden extenderla.
// Mejora el control de herencia en jerarquías cerradas.
public sealed class Vehiculo permits Auto, Camion { }

// Clase Auto que extiende Vehiculo. Se declara como final para no permitir más herencia.
final class Auto extends Vehiculo { }

// Clase Camion que también extiende Vehiculo y es final.
final class Camion extends Vehiculo { }