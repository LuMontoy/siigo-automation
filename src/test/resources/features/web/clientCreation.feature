Feature: Creacion de clientes

  Scenario: creacion exitosa de un cliente tipo persona
    Given el usuario inicio sesion en el aplicativo
    When se dirige al modulo de creacion de clientes
    And llena los campos obligatorios para cliente tipo persona
    Then visualizara un mensaje de creacion exitosa
    And sera redirigido al perfil del cliente creado