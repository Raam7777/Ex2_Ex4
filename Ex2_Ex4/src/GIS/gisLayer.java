package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class gisLayer implements GIS_layer {

	//------------------------private----------------------\\
	private ArrayList<GIS_element> layer=new ArrayList<GIS_element>();

	
	//-----------------------------------------------------\\
	
	
	/**
	 * gets the whole string from a particular file.
	 * @param arrElement - ArrayList of gisElement.
	 */
	public gisLayer(ArrayList<gisElement> arrElement) {
		for (int i = 0; i < arrElement.size(); i++)
			this.layer.add(arrElement.get(i));
	}

	/**
	 * adding element to the layer.
	 * @param e representing an element.
	 * @return boolean.
	 */
	public boolean add(GIS_element e) {
		return layer.add(e);
	}
	
	/**
	 * adding the collection to the set.
	 * @param collection of elements.
	 * @return boolean.
	 */
	public boolean addAll(Collection<? extends GIS_element> e) {
		return layer.addAll(e);
	}
	
	/**
	 * clearing the Layer.
	 */
	public void clear() {
		layer.clear();

	}
	
	/**
	 * if the object is in the collection so true, otherwise false.
	 * @param e - object.
	 * @return boolean.
	 */
	public boolean contains(Object e) {
		return layer.contains(e);
	}
	
	/**
	 * if all the objects are in the collection so true, otherwise false.
	 * @param e - all object.
	 * @return boolean.
	 */
	public boolean containsAll(Collection<?> e) {
		return layer.containsAll(e);
	}
	
	/**
	 * if the layer is empty so true, otherwise false.
	 *@return boolean.
	 */
	public boolean isEmpty() {
		return layer.isEmpty();

	}
	/**
	 * Iterator pointing to the elements in the layer.
	 * @return iterator.
	 */
	public Iterator<GIS_element> iterator() {
		Iterator<GIS_element> it= layer.iterator();  //questionable?
		return it;
	}
	
	/**
	 * remove an object from the layer.
	 * @return boolean.
	 */
	public boolean remove(Object e) {
		return layer.remove(e);
	}
	
	/**
	 * remove a from objects from the layer according to the collection given.
	 * @return boolean
	 */
	public boolean removeAll(Collection<?> e) {
		return layer.removeAll(e);
	}
	
	/**
	 * retaining only the objects of the given collection.
	 * @return boolean.
	 */
	public boolean retainAll(Collection<?> e) {
		return layer.retainAll(e);
	}
	
	/**
	 * The size of the element in layer.
	 * @return how many elements.
	 */
	public int size() {
		return layer.size();
	} 
	
	/**
	 * turning the collection into array.
	 * @return array of object.
	 */
	public Object[] toArray() {
		return 	layer.toArray();

	}
	/**
	 * turning the collection into array according to the array's given objects.
	 *  @return array of object.
	 */
	public <T> T[] toArray(T[] e) {
		return layer.toArray(e);
	}
	
	/**
	 *  get metaData to later.
	 *  @return metaData of layer.
	 */
	public Meta_data get_Meta_data() { 					
		return this.layer.get(0).getData();
	}

}
