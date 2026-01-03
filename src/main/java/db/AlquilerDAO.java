package db;

import data.AlquilerViviendaData;
import data.AlquilerViviendaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAO {

    public List<AlquilerViviendaData> listarAlquilerViv(String codReferencia, Integer numExpediente, java.sql.Date fechaEntrada, java.sql.Date fechaSalida, String estado) {
        String sql
                = "SELECT v.cod_referencia, a.num_expediente, a.fecha_entrada, a.estado, a.id_alquiler, a.id_vivienda,\n"
                + "a.tiempo_estimado, a.nombre_cliente, a.dni_cliente, a.correo_cliente, a.telefono_cliente, a.facturacion\n"
                + "FROM alquileres a\n"
                + "INNER JOIN vivienda v\n"
                + "ON a.id_vivienda = v.id_vivienda\n"
                + "WHERE v.cod_referencia = ?\n"
                + //Para el código de referencia.
                "AND a.num_expediente = ?\n"
                + //Para el número de expediente
                "AND a.fecha_entrada BETWEEN ? AND ?\n"
                + //Para la fecha
                "AND a.estado = ?\n";  //Para el estado

        //Array para obtener esos valores.
        List<AlquilerViviendaData> salida = new ArrayList<>();
        try (Connection connec = MySQLConnection.getConnection(); PreparedStatement ps = connec.prepareStatement(sql);) {

            ps.setString(1, codReferencia);
            ps.setInt(2, numExpediente);
            ps.setDate(3, fechaEntrada);
            ps.setDate(4, fechaSalida);
            ps.setString(5, estado);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AlquilerViviendaData alquiler = obtenerAlquilerVivienda(rs);
                salida.add(alquiler);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error " + e.getMessage(), e);
        }
        return salida;
    }

    //Método para obtener los datos
    private AlquilerViviendaData obtenerAlquilerVivienda(ResultSet rs) throws SQLException {
        AlquilerViviendaData vivienda = new AlquilerViviendaData(
                rs.getString("cod_referencia"),
                rs.getInt("num_expediente"),
                rs.getDate("fecha_entrada"),
                rs.getInt("tiempo_estimado"),
                rs.getString("estado"),
                rs.getString("nombre_cliente"),
                rs.getString("dni_cliente"),
                rs.getString("correo_cliente"),
                rs.getInt("telefono_cliente"),
                rs.getDouble("facturacion"));
        return vivienda;
    }
}
