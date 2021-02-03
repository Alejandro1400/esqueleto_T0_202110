package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) {
			// TODO implementar Listo
			
			if(elementos[i] != "")
			{
				return elementos[i];
			}
			else
			{
			return null;
			}
		}

		public String buscar(String dato) {
			// TODO implementar Listo
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			String resp = null;
			boolean existe = false;
			
			for( int i=0; i<tamanoAct && !existe; i++)
			{
				if(elementos[i].compareToIgnoreCase(dato) == 0)
				{
					existe = true;
					resp = elementos[i];
				}
			}
			
			return resp;
		}

		public String eliminar(String dato) {
			// TODO implementar Listo
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			String eliminado = null;
			boolean existe = false;
			
			for( int i=0; i<tamanoAct && !existe; i++)
			{
				if(elementos[i].compareToIgnoreCase(dato) == 0)
				{
					existe = true;
					eliminado = elementos[i];
					elementos[i] = null;
					tamanoAct--;
					
					if( elementos[i]==null && i < tamanoMax )
					{
						for( int j=i; j<tamanoMax; j++)
						{
							elementos[i] = elementos[j+1];
							i++;
							
						}
					}
				
				}
				
			}
			
			return eliminado;
		}

}
