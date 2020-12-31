Feature: Funcionalidad Alta Clientes

  Validar que se permita el alta de clientes Persona Fisica

  Scenario: Alta Clientes Persona Fisica

    Given Ingresa al sistema satisfactoriamente "N3273075" y "1xsPJzRT"
    When Usuario llena datos del cliente
    Then validar id de clientes





