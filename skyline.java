class node {
	boolean isLeft;
	int height;
	int x;
	public node(int x, int height, boolean isLeft) {
		this.x = x;
		this.height = height;
		this.isLeft = isLeft;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null)
			return false;
		node item = (node) that;
		return (height == item.height);
	}

 	public static final Comparator<node> ByHeight = new Comparator<node>() {
		@Override
		public int compare(node node1, node node2) {
			// reverse order
			// get the maximum
			return -(node1.height - node2.height);
		}
	};

	public static final Comparator<node> ByX = new Comparator<node>() {
		@Override
		public int compare(node node1, node node2) {
			if (node1.x != node2.x)
				return node1.x - node2.x; 
			else if (node1.height != node2.height) {
				return node1.height - node2.height;
			} else {
			    if (node1.isLeft) {
			        return -1;
			    } else {
			        return 1;
			    }
			}
		}
	};
}

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> re = new ArrayList<>();
    	if (buildings == null || buildings.length < 1) {
    		return re;
    	}

    	List<node> nodes = new ArrayList<>(buildings.length * 2);
    	for (int[] building : buildings) {
    		nodes.add(new node(building[0], building[2], true));
    		nodes.add(new node(building[1], building[2], false));
    	}

    	Collections.sort(nodes, node.ByX);
    	PriorityQueue<node> pq = new PriorityQueue<>(1, node.ByHeight);
    	node ground_hist = null;
    	for (node item : nodes) {
			if (item.isLeft) {
				if (pq.size() == 0) {
					if (ground_hist != null && ground_hist.x != item.x) {
						re.add(new int[]{ground_hist.x, 0});
					}
				} else {
					if (item.height > pq.peek().height && item.x != pq.peek().x) {
						re.add(new int[]{pq.peek().x, pq.peek().height});
					}
				}
				pq.add(item);
			} else {
				if (pq.peek().equals(item)) {
				    if (re.size() == 0 || re.get(re.size() - 1)[1] != pq.peek().height) {
					    re.add(new int[]{pq.peek().x, pq.peek().height});
				    }
				    
					pq.remove(item);

					if (pq.size() == 0) {
						ground_hist = item;
					} else {
						pq.peek().x = item.x;
					}
				} else {
					pq.remove(item);				
				}
			}			
    	}
    	re.add(new int[]{ground_hist.x, 0});
    	return re;
    }
}