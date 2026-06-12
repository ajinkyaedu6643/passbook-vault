import api from "../api/api";

export const getAccounts = async (
    page = 0,
    size = 10
) => {

    const response = await api.get(
        `/accounts/paged?page=${page}&size=${size}`
    );

    return response.data;
};

export const searchAccounts = async (
    keyword
) => {

    const response = await api.get(
        `/accounts/search/keyword?keyword=${keyword}`
    );

    return response.data;
};