package main.java.io.github.dramanebamba.pole_info.service;


import java.util.Vector;
import javax.enterprise.context.ApplicationScoped;
import main.java.io.github.dramanebamba.pole_info.model.Preference;

@ApplicationScoped
public class PreferenceService {

	private static Vector<Preference> preference = new Vector<>();

	public static Vector<Preference> getPreference() {
		return preference;
	}

	public static void setPreference(Vector<Preference> preference) {
		PreferenceService.preference = preference;
	}

}
