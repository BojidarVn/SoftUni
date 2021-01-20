package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.AbstractUnit;
import barracksWars.models.units.Horseman;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType)  {



		try {

			Class<?> unit=Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> declaredConstructor = unit.getDeclaredConstructor();
			Object object = declaredConstructor.newInstance();

			if (object instanceof AbstractUnit) {
				return (Unit) object;
			} else {

			}

		} catch (ClassNotFoundException  | NoSuchMethodException  e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}


		throw new IllegalArgumentException("Provided type is not a Unit");
	}
}
