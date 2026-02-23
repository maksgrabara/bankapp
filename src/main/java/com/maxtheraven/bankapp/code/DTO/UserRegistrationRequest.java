package com.maxtheraven.bankapp.code.DTO;

public record UserRegistrationRequest(String uname, String ulastname, String password, String birthDate) {}

//Co to jest w ogóle? Specjalny typ klasy przeznaczony do przenoszenia danych
//Java automatycznie generuje: prywatne, finalne pola, konstruktor, gettery (login() i password()), equals(), hashCode(), toString()
//Dostęp do pól wygląda tak: request.uname(), request.password()