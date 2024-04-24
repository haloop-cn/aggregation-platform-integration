import {ClueData} from "@/components/ClueForm";
import request from "umi-request";

export const randomClue = async (): Promise<ClueData> => {
  return request.get("/api/agg/random")
}

export const submitClue = async (data: ClueData): Promise<void> => {
  return request.post("/api/agg/push", {data})
}

export const updateClue = async (data: ClueData): Promise<void> => {
  return request.put("/api/agg/update", {data})
}