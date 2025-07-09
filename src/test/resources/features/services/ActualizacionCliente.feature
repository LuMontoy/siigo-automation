Feature: Actualizacion de clientes

  Scenario: Actualizacion exitosa de la informacion de un cliente
    Given el usuario creo un nuevo cliente
    And actualizo la informacion del campo job
    When consume el servico para obterner los datos actuales
    Then visualizara respuesta con codigo de estado exitoso
    And visualizara los datos actualizados del cliente