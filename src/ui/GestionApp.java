package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.*;

public class GestionApp {
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Colaborador> colaboradores = new ArrayList<>();
    private ArrayList<Solicitud> solicitudes = new ArrayList<>();
    private ArrayList<Proyecto> proyectos = new ArrayList<>();
    private ArrayList<Area> areas = new ArrayList<>();

    public static void main(String[] args) {
        GestionApp objMain = new GestionApp();
        boolean menu = true;
        while (menu) {
            System.out.println("\n<----------------------ICESI GESTION---------------------->");
            System.out.println("1). Agregar un nuevo colaborador.");
            System.out.println("2). Buscar a un colaborador por su nombre o ID.");
            System.out.println("3). Lista de todos los Colaboradores");
            System.out.println("4). Calcular la eficiencia del colaborador.");
            System.out.println("5). Eliminar Colaborador.");
            System.out.println("6). Registrar una nueva solicitud.");
            System.out.println("7). Cambiar el estado de una solicitud.");
            System.out.println("8). Registrar un nuevo proyecto.");
            System.out.println("9). Finalizar un proyecto.");
            System.out.println("10). Visualizar proyectos en forma matricial.");
            System.out.println("11). Crear un área.");
            System.out.println("12). Adicionar una certificación a un colaborador externo.");
            System.out.println("13). Calcular el bonus de un colaborador externo.");
            System.out.println("14). Salir del Programa.");
            System.out.print("Digite la opción a seleccionar: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    objMain.agregarColab();
                    break;
                case 2:
                    objMain.buscarColab();
                    break;
                case 3:
                    objMain.listaColab();
                    break;
                case 4:
                    objMain.calcEficiencia();
                    break;
                case 5:
                    objMain.eliminarColab();
                    break;
                case 6:
                    objMain.registrarSolicitud();
                    break;
                case 7:
                    objMain.cambiarEstadoSolicitud();
                    break;
                case 8:
                    objMain.registrarProyecto();
                    break;
                case 9:
                    objMain.finalizarProyecto();
                    break;
                case 10:
                    objMain.visualizarProyectosMatricial();
                    break;
                case 11:
                    objMain.crearArea();
                    break;
                case 12:    
                    objMain.adicionarCertificacionExterna();
                    break;
                case 13:
                    objMain.calcularBonusExterno();
                    break;
                case 14:
                    menu = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción del 1 al 14.");
                    break;
            }
        }
        System.out.println("Saliendo del programa. ¡Hasta luego!");
    }

    public void agregarColab() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el nombre del Colaborador: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido del Colaborador: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese el ID del Colaborador: ");
        String id = sc.nextLine();
        System.out.print("Ingrese el correo institucional del Colaborador: ");
        String correo = sc.nextLine();
        int extension = 0;
        int mejoras = 0;
    
        boolean seleccionValida = false;
        while (!seleccionValida) {
            System.out.println("\n¿El colaborador tiene número de extensión?");
            System.out.println("1). Si");
            System.out.println("2). No");
            System.out.print("Ingrese la opción: ");
            int extencion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea pendiente
    
            switch (extencion) {
                case 1:
                    System.out.print("Ponga la extensión sin el guión (-): ");
                    extension = sc.nextInt();
                    seleccionValida = true;
                    break;
                case 2:
                    System.out.println("No tiene extensión.");
                    seleccionValida = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija 1 o 2.");
                    break;
            }
        }
    
        seleccionValida = false;
        while (!seleccionValida) {
            System.out.println("\n¿Es del Área de Transformación y Mejoramiento?");
            System.out.println("1). Si");
            System.out.println("2). No");
            System.out.print("Ingrese la opción: ");
            int respuesta = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea pendiente
    
            switch (respuesta) {
                case 1:
                    seleccionValida = true;
                    System.out.print("Ingrese la cantidad de mejoras implementadas: ");
                    mejoras = sc.nextInt();
                    System.out.print("Ingrese el número de proyectos finalizados: ");
                    int proyectos = sc.nextInt();
                    colaboradores.add(new ColaboradorTransformacion(nombre, apellido, id, correo, extension, mejoras, proyectos));
                    break;
                case 2:
                    seleccionValida = true;
                    System.out.println("El colaborador no es del área de Transformación y Mejoramiento.");
                    System.out.println("¿Es un colaborador externo?");
                    System.out.println("1). Si");
                    System.out.println("2). No");
                    System.out.print("Ingrese la opción: ");
                    int opcionExterno = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea pendiente
                    switch (opcionExterno) {
                        case 1:
                            System.out.print("Ingrese el número de certificaciones: ");
                            int certificaciones = sc.nextInt();
                            colaboradores.add(new ColaboradorExterno(nombre, apellido, id, correo, extension, certificaciones));
                            break;
                        case 2:
                            colaboradores.add(new Colaborador(nombre, apellido, id, correo, extension));
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, elija 1 o 2.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija 1 o 2.");
                    break;
            }
        }
    }

    private void buscarColab() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el ID del Colaborador a buscar: ");
        String idBuscar = sc.nextLine();

        boolean encontrado = false;
        for (Colaborador colab : colaboradores) {
            if (colab.getId().equals(idBuscar)) {
                encontrado = true;
                System.out.println("\n<-----------Informacion del Colaborador----------->");
                System.out.println("Información del Colaborador:");
                System.out.println("Nombre: " + colab.getNombre());
                System.out.println("Apellido: " + colab.getApellido());
                System.out.println("ID: " + colab.getId());
                System.out.println("Correo: " + colab.getCorreo());
                if (colab instanceof ColaboradorTransformacion) {
                    ColaboradorTransformacion colabTransf = (ColaboradorTransformacion) colab;
                    System.out.println("Mejoras Implementadas: " + colabTransf.getMejorasImplementadas());
                    System.out.println("Proyectos Finalizados: " + colabTransf.getProyectosFinalizados());
                }
                System.out.println("<------------------------------------------------->");
                System.out.println("Presione 'Enter' para volver al menú");
                sc.nextLine();
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No hay ningún colaborador con esa ID.");
            System.out.println("Presione 'Enter' para volver al menú");
            sc.nextLine();
        }
    }

    public void listaColab() {
        System.out.println("\n---------------------------");
        System.out.println("Lista de todos los Colaboradores:");
        for (Colaborador colab : colaboradores) {
            System.out.println(colab.toString());
            System.out.println("---------------------------");
        }
        System.out.println("Presione 'Enter' para volver al menú");
        sc.nextLine();
    }

    public void calcEficiencia() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el ID del Colaborador a buscar: ");
        String idBuscar = sc.nextLine();

        // Buscar el colaborador por su ID
        Colaborador colaborador = buscarColabPorId(idBuscar);
        if (colaborador == null) {
            System.out.println("No se encontró ningún colaborador con ese ID.");
            return;
        }

        // Verificar si el colaborador es de tipo ColaboradorTransformacion
        if (colaborador instanceof ColaboradorTransformacion) {
            ColaboradorTransformacion colaboradorTransformacion = (ColaboradorTransformacion) colaborador;

            int mejoras = colaboradorTransformacion.getMejorasImplementadas();
            int proyectos = colaboradorTransformacion.getProyectosFinalizados();

            if (proyectos == 0) {
                System.out.println("El colaborador no ha finalizado ningún proyecto. No se puede calcular la eficiencia.");
            } else {
                double eficiencia = (double) mejoras / proyectos;
                System.out.println("La eficiencia del colaborador " + colaborador.getNombre() + " es: " + eficiencia);
            }
        } else {
            System.out.println("El colaborador no pertenece al área de Transformación y Mejoramiento.");
        }
    }

    private Colaborador buscarColabPorId(String idBuscar) {
        for (Colaborador colab : colaboradores) {
            if (colab.getId().equals(idBuscar)) {
                return colab;
            }
        }
        return null;
    }

    public void eliminarColab() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el ID del Colaborador a eliminar: ");
        String idBuscar = sc.nextLine();

        Colaborador colabAEliminar = buscarColabPorId(idBuscar);

        if (colabAEliminar != null) {
            System.out.println("\n¿Está seguro de que desea eliminar al siguiente colaborador?");
            System.out.printf("Nombre: %s%n", colabAEliminar.getNombre());
            System.out.printf("Apellido: %s%n", colabAEliminar.getApellido());
            System.out.printf("ID: %s%n", colabAEliminar.getId());

            int confirmacion = mostrarOpcionesConfirmacionEliminacion();
            switch (confirmacion) {
                case 1 -> {
                    colaboradores.remove(colabAEliminar);
                    System.out.println("Colaborador eliminado correctamente.");
                }
                case 2 -> System.out.println("Operación de eliminación cancelada.");
                default -> System.out.println("Opción inválida. No se realizó la eliminación.");
            }
        } else {
            System.out.println("No se encontró ningún colaborador con ese ID.");
        }
    }

    private int mostrarOpcionesConfirmacionEliminacion() {
        System.out.println("\n¿Está seguro de que desea eliminar al colaborador?");
        System.out.println("1. Sí, eliminar.");
        System.out.println("2. No, cancelar.");
        System.out.print("Ingrese la opción: ");
        return sc.nextInt();
    }

    public void registrarSolicitud() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese la descripción de la solicitud: ");
        String descripcion = sc.nextLine();
        System.out.print("Ingrese el ID del colaborador responsable: ");
        String idResponsable = sc.nextLine();
        Colaborador responsable = null;
        for (Colaborador colab : colaboradores) {
            if (colab.getId().equalsIgnoreCase(idResponsable)) {
                responsable = colab;
                break;
            }
        }
        if (responsable == null) {
            System.out.println("Colaborador responsable no encontrado.");
            return;
        }
        System.out.print("Ingrese el ID del área solicitante: ");
        String idArea = sc.nextLine();
        Area areaSolicitante = null;
        for (Area area : areas) {
            if (area.getCodigo().equalsIgnoreCase(idArea)) {
                areaSolicitante = area;
                break;
            }
        }
        if (areaSolicitante == null) {
            System.out.println("Área solicitante no encontrada.");
            return;
        }
        Solicitud nuevaSolicitud = new Solicitud(new Date(), descripcion, responsable, areaSolicitante);
        solicitudes.add(nuevaSolicitud);
        System.out.println("Solicitud registrada exitosamente.");
    }

    public void cambiarEstadoSolicitud() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese la descripción de la solicitud: ");
        String descripcion = sc.nextLine();
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getDescripcion().equalsIgnoreCase(descripcion)) {
                System.out.print("Ingrese el nuevo estado de la solicitud: ");
                String nuevoEstado = sc.nextLine();
                solicitud.setEstado(nuevoEstado);
                System.out.println("Estado de la solicitud actualizado exitosamente.");
                return;
            }
        }
        System.out.println("Solicitud no encontrada.");
    }

    public void registrarProyecto() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el código del proyecto: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese el nombre del proyecto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la prioridad del proyecto (Alta, Media, Baja): ");
        String prioridad = sc.nextLine();
        System.out.print("Ingrese el ID del colaborador líder del proyecto: ");
        String idLider = sc.nextLine();
        Colaborador lider = null;
        for (Colaborador colab : colaboradores) {
            if (colab.getId().equalsIgnoreCase(idLider)) {
                lider = colab;
                break;
            }
        }
        if (lider == null) {
            System.out.println("Colaborador líder no encontrado.");
            return;
        }
        System.out.print("Ingrese la fecha estimada de cierre (dd/MM/yyyy): ");
        String fechaCierreStr = sc.nextLine();
        Date fechaEstimadaCierre;
        try {
            fechaEstimadaCierre = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(fechaCierreStr);
        } catch (Exception e) {
            System.out.println("Fecha inválida.");
            return;
        }

        System.out.println("\nSeleccione el tipo de proyecto:");
        System.out.println("1). Proyecto de Gestión del Conocimiento.");
        System.out.println("2). Proyecto de Transformación y Mejora de Procesos.");
        System.out.println("3). Otro tipo de proyecto.");
        System.out.print("Ingrese la opción: ");
        int tipoProyecto = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente

        Proyecto nuevoProyecto = null;

        switch (tipoProyecto) {
            case 1:
                System.out.print("Ingrese el nombre del proceso de conocimiento: ");
                String nombreProceso = sc.nextLine();
                System.out.print("Ingrese la comunidad impactada: ");
                String comunidadImpactada = sc.nextLine();
                System.out.print("Ingrese el tipo de gestión del conocimiento: ");
                String tipoGestion = sc.nextLine();
                nuevoProyecto = new ProyectoGestionConocimiento(codigo, nombre, prioridad, lider, fechaEstimadaCierre, nombreProceso, comunidadImpactada, tipoGestion);
                break;
            case 2:
                System.out.print("Ingrese el código del proceso de transformación: ");
                String codigoProceso = sc.nextLine();
                nuevoProyecto = new ProyectoTransformacionMejora(codigo, nombre, prioridad, lider, fechaEstimadaCierre, codigoProceso);
                break;
            case 3:
                nuevoProyecto = new Proyecto(codigo, nombre, prioridad, lider, fechaEstimadaCierre);
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        proyectos.add(nuevoProyecto);
        System.out.println("Proyecto registrado exitosamente.");
    }

    public void finalizarProyecto() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el código del proyecto a finalizar: ");
        String codigo = sc.nextLine();
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getCodigo().equalsIgnoreCase(codigo)) {
                proyecto.setFechaCierreReal(new Date());
                proyecto.setEstado("Finalizado");
                System.out.println("Proyecto finalizado exitosamente.");
                return;
            }
        }
        System.out.println("Proyecto no encontrado.");
    }

    public void visualizarProyectosMatricial() {
        System.out.println("\n<--------------------Proyectos-------------------->");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-20s %-15s %-15s%n", "Código", "Nombre", "Estado", "Prioridad", "Líder", "Fecha Estimada", "Fecha Asignación", "Fecha Cierre");
        for (Proyecto proyecto : proyectos) {
            System.out.printf("%-10s %-20s %-10s %-10s %-15s %-20s %-15s %-15s%n", proyecto.getCodigo(), proyecto.getNombre(), proyecto.getEstado(), proyecto.getPrioridad(), proyecto.getLider().getNombre(), proyecto.getFechaEstimadaCierre(), proyecto.getFechaAsignacion(), proyecto.getFechaCierreReal());
        }
        System.out.println("<------------------------------------------------>");
    }

    public void crearArea() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el nombre del área: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el código del área: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese el ID del colaborador responsable: ");
        String idResponsable = sc.nextLine();
    
        Colaborador responsable = buscarColabPorId(idResponsable);
        if (responsable == null) {
            System.out.println("Colaborador responsable no encontrado. No se puede crear el área.");
            return;
        }
    
        Area nuevaArea = new Area(nombre, codigo, responsable);
        areas.add(nuevaArea);
    
        System.out.println("Área creada exitosamente.");
    }

    public void adicionarCertificacionExterna() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el ID del Colaborador Externo: ");
        String idBuscar = sc.nextLine();
    
        Colaborador colaborador = buscarColabPorId(idBuscar);
        if (colaborador instanceof ColaboradorExterno) {
            ColaboradorExterno colaboradorExterno = (ColaboradorExterno) colaborador;
            colaboradorExterno.addCertificacion();
            System.out.println("Certificación añadida exitosamente.");
        } else {
            System.out.println("El colaborador no es un colaborador externo o no existe.");
        }
    }
    
    public void calcularBonusExterno() {
        sc.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("\nIngrese el ID del Colaborador Externo: ");
        String idBuscar = sc.nextLine();
        System.out.print("Ingrese la cantidad de horas trabajadas: ");
        int horasTrabajadas = sc.nextInt();
    
        Colaborador colaborador = buscarColabPorId(idBuscar);
        if (colaborador instanceof ColaboradorExterno) {
            ColaboradorExterno colaboradorExterno = (ColaboradorExterno) colaborador;
            double bonus = colaboradorExterno.calcularBonus(horasTrabajadas);
            System.out.println("El bonus del colaborador externo " + colaboradorExterno.getNombre() + " es: " + bonus);
        } else {
            System.out.println("El colaborador no es un colaborador externo o no existe.");
        }
    }
}