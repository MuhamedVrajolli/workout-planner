package com.fitness.app.configuration.hibernate;

import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class IntegerArrayType implements UserType<Integer[]> {

  @Override
  public int getSqlType() {
    return Types.ARRAY;
  }

  @Override
  public Class<Integer[]> returnedClass() {
    return Integer[].class;
  }

  @Override
  public boolean equals(Integer[] x, Integer[] y) throws HibernateException {
    return x != null && y != null && Arrays.equals(x, y);
  }

  @Override
  public int hashCode(Integer[] x) throws HibernateException {
    return Arrays.hashCode(x);
  }

  @Override
  public Integer[] nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session,
      Object owner) throws SQLException {
    Array array = rs.getArray(position);
    return array != null ? (Integer[]) array.getArray() : null;
  }

  @Override
  public void nullSafeSet(PreparedStatement st, Integer[] value, int index, SharedSessionContractImplementor session)
      throws SQLException {
    if (st != null) {
      if (value != null) {
        try (Connection connection = session.getJdbcConnectionAccess().obtainConnection()) {
          st.setArray(index, connection.createArrayOf("integer", value));
        }
      } else {
        st.setNull(index, Types.ARRAY);
      }
    }
  }

  @Override
  public Integer[] deepCopy(Integer[] value) throws HibernateException {
    return value != null ? Arrays.copyOf(value, (value).length) : null;
  }

  @Override
  public boolean isMutable() {
    return true;
  }

  @Override
  public Serializable disassemble(Integer[] value) throws HibernateException {
    return deepCopy(value);
  }

  @Override
  public Integer[] assemble(Serializable cached, Object owner) throws HibernateException {
    return deepCopy((Integer[]) cached);
  }

  @Override
  public Integer[] replace(Integer[] original, Integer[] target, Object owner) throws HibernateException {
    return deepCopy(original);
  }
}
