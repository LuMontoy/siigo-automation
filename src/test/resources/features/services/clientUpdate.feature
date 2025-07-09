Feature: Creacion, actualizacion, consulta y eliminacion de clientes

  Scenario: Creacion exitosa de un cliente
    Given el usuario debe registrar un cliente nuevo
    When consume el servico para crearlo en el sistema
    Then visualizara la respuesta con codigo de estado 201
    And los datos del cliente seran los mismos que envio en la peticion

  Scenario: Actualizacion exitosa de un cliente
    Given el usuario tiene el Id de un cliente ya registrado
    When consume el servico para actualizar sus datos en el sistema
    Then visualizara la respuesta con codigo de estado 200
    And los datos del cliente seran los mismos que envio en la peticion

  Scenario: Eliminacion exitosa de un cliente
    Given el usuario tiene el Id de un cliente ya registrado
    When consume el servico para eliminar sus datos en el sistema
    Then visualizara la respuesta con codigo de estado 204

  Scenario: Consulta exitosa de un cliente
    Given el usuario tiene el Id de un cliente ya registrado
    When consume el servico para consultar sus datos en el sistema
    Then visualizara la respuesta con codigo de estado 200
    And visualizara los datos del cliente