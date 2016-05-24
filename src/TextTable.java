import static java.util.stream.Collectors.joining ;
 
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
 
 
/**
 * Hilfsklasse f�r tabellarisches Logging.
 *
 * @param <T>
 *           der Zeilendatentyp
 */
public class TextTable<T> {
 
   final ArrayList<Col<T>> cols;
 
   public TextTable( final ArrayList<Col<T>> cols) {
      super();
      this.cols = cols;
   }
 
   public void print(final Collection<T> data, final Consumer<String> logger) {
      final String formatStr = cols.stream().map(col -> getColFormat(data, col )).collect(joining( " | "));
 
      // header:
      logger.accept(String.format(formatStr , cols .stream().map(c -> c.getHeader()).toArray()));
 
      // data:
      data.forEach(r -> {
         logger.accept(String. format(formatStr, cols.stream().map( c -> c.getToStringFct().apply( r)).toArray()));
      });
   }
 
   private String getColFormat( final Collection<T> data, final Col<T> col) {
      return "%" + orientation( col) + getColWidth( data, col) + "s";
   }
 
   private int getColWidth( final Collection<T> data, final Col<T> c) {
      return Math.max(c .getHeader().length(), getMaxValueWidth(data, c.getToStringFct()).getAsInt());
   }
 
   private String orientation( final Col<T> c) {
      return c.getOrientation() == Col.Orientation. LEFT ? "-" : "";
   }
 
   private OptionalInt getMaxValueWidth( final Collection<T> data, final Function<T, String> colExtr) {
      return data.stream().mapToInt( s -> colExtr.apply( s).length()).max();
   }
 
   /**
    * Spaltendefinition.
    *
    * @param <T>
    *           Zeilendatentyp
    */
   public static class Col<T> {
 
      public static enum Orientation {
         LEFT,
         RIGHT
      }
 
      private final String header;
      private final Function<T, String> toStringFct;
      private final Orientation orientation;
 
      public Col(final String header, final Function<T, String> toStringFct, final Orientation orientation) {
         super();
         this. header = header;
         this. toStringFct = toStringFct;
         this. orientation = orientation;
      }
 
      public String getHeader() {
         return header;
      }
 
      public Function<T, String> getToStringFct() {
         return toStringFct;
      }
 
      public Orientation getOrientation() {
         return orientation;
      }
   }
 
}