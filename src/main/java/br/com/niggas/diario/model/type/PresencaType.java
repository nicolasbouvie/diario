package br.com.niggas.diario.model.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.EnhancedUserType;

public class PresencaType implements EnhancedUserType {

	@Override
	public int[] sqlTypes() {
		return new int[] {Types.CHAR};
	}

	@Override
	public Class<?> returnedClass() {
		return Presenca.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		boolean isEqual = false;
        if (x == y) {
            isEqual = true;
        }
        if (null == x || null == y) {
            isEqual = false;
        } else {
            isEqual = x.equals(y);
        }
        return isEqual;
    }

	@Override
	public int hashCode(Object x) throws HibernateException {
        return ((Presenca) x).hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Presenca p = null;
        String name = rs.getString(names[0]);
        if (name != null) {
            p = Presenca.getPresenca(name);
        }
        return p;
    }

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if (value == null) {
            st.setNull(index, sqlTypes()[0]);
        } else {
            Presenca presenca = (Presenca) value;
            st.setObject(index, presenca.id, sqlTypes()[0]);
        }		
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public String objectToSQLString(Object value) {
		Presenca presenca = (Presenca) value;
		return "'" + presenca.id + "'";
	}

	@Override
	public String toXMLString(Object value) {
		Presenca presenca = (Presenca) value;
		return presenca.name();
	}

	@Override
	public Object fromXMLString(String xmlValue) {
		return Presenca.valueOf(xmlValue);
	}
}
