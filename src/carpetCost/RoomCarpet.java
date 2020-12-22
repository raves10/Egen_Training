package carpetCost;

public class RoomCarpet {

	public RoomDimension roomDim;
	public double costPerSqFt;
	
	public RoomCarpet(RoomDimension roomDim, double costPerSqFt) {
		
		this.roomDim = roomDim;
		this.costPerSqFt = costPerSqFt;
	}

	public RoomDimension getRoomDim() {
		return roomDim;
	}

	public void setRoomDim(RoomDimension roomDim) {
		this.roomDim = roomDim;
	}

	public double getCostPerSqFt() {
		return costPerSqFt;
	}

	public void setCostPerSqFt(double costPerSqFt) {
		this.costPerSqFt = costPerSqFt;
	}


	public double totalCost()
	{
		return (this.roomDim.getArea() * this.costPerSqFt);
	}

	@Override
	public String toString() {
		return "RoomCarpet [roomDim=" + roomDim + ", costPerSqFt=" + costPerSqFt + "]";
	}
	
	
	
}
