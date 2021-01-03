package orm;

import orm.annotation.Column;
import orm.annotation.Entity;
import orm.annotation.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext {
    private static final String SELECT_STAR_FROM = "SELECT * FROM ";
    private static final String INSERT_QUERY = "INSERT INTO %s (%s) VALUE (%s) ;";
    private static final String UPDATE_QUERY = "UPDATE %s SET %s WHERE %s ;";
    private static final String DELETE_QUERY = "DELETE FROM %s WHERE %s ;";


    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean persist(Object entity) throws IllegalAccessException, SQLException {
        Field primary = getIdField(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        return (value != null && (int) value > 0) ?
                doUpdate(entity, primary) :
                doInsert(entity, primary);

        // return false;
    }


    @Override
    public Iterable find(Class table) {
        return null;
    }

    @Override
    public Iterable find(Class table, String where) {
        return null;
    }

    @Override
    public Object findFirst(Class table) {
        return null;
    }

    @Override
    public Object findFirst(Class table, String where) {
        return null;
    }

    //Utility methods

    private boolean doInsert(Object entity, Field primary) throws SQLException {
        String tableName = getTableName(entity.getClass());
       String fieldNamesStr = getFieldName(entity).stream().collect(Collectors.joining(", "));
       String fieldValuesStr = getFieldValues(entity).stream().collect(Collectors.joining(", "));

        String insertQuery = String.format(INSERT_QUERY,tableName,fieldNamesStr, fieldValuesStr);
        return executeQuery(insertQuery);
    }

    private boolean executeQuery(String sql) throws SQLException {
        PreparedStatement ps=connection.prepareStatement(sql);
        return ps.execute();

    }


    private boolean doUpdate(Object entity, Field primary) {
        return false;
    }


    private Field getIdField(Class entity) {

        return Arrays.stream(entity.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entry does not have a primary key"));

    }

    private String getTableName(Class<?> entity) {
        Entity entityAnnotation = entity.getAnnotation(Entity.class);

        if (entityAnnotation != null && entityAnnotation.name().length() > 0) {
            return entityAnnotation.name();
        } else {
            return entity.getSimpleName();
        }
    }



    private List<String> getFieldValues(Object entity) {
        Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> {
                    field.setAccessible(true);
                    return field.getAnnotation(Column.class).name();
                })
                .collect(Collectors.toList());

        return null;
    }




    private List<String> getFieldName(Object entity) {
        Function<Field, String> getFieldValue = field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(entity);
                return field.getType() == String.class || field.getType() == LocalDate.class ?
                        String.format("'%s'", value.toString()) :
                        value.toString();

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return "";
        };


        Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(getFieldValue)
                .collect(Collectors.toList());

        return null;
    }


}
