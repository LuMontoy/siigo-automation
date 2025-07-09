Feature: Creacion de clientes

  Scenario: creacion exitosa de un cliente tipo proveedor
    Given el usuario inicio sesion en el aplicativo
    And navego hasta el modulo de creacion de clientes
    When llena el formulario con los campos obligatorios
    Then visualizara el cliente creado en el modulo de terceros
    And los datos del cliente seran los mismos con los que lo creo