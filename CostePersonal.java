public class CostePersonal {

    private static final int FACTOR_HORAS_EXTRAS = 20;

    public static float calcularCosteDelPersonal(Trabajador[] trabajadores) {
        float costeFinal = 0;
        for (Trabajador trabajador : trabajadores) {
            if (esDirectorOSubdirector(trabajador)) {
                costeFinal += trabajador.getNomina();
            } else {
                costeFinal += calcularCosteConHorasExtras(trabajador);
            }
        }
        return costeFinal;
    }

    private static boolean esDirectorOSubdirector(Trabajador trabajador) {
        return trabajador.getTipoTrabajador() == Trabajador.DIRECTOR ||
               trabajador.getTipoTrabajador() == Trabajador.SUBDIRECTOR;
    }

    private static float calcularCosteConHorasExtras(Trabajador trabajador) {
        return trabajador.getNomina() + (trabajador.getHorasExtras() * FACTOR_HORAS_EXTRAS);
    }
}
